package com.jeongsu.moni.service;

import com.jeongsu.moni.model.TablespaceStatus;
import com.jeongsu.moni.repository.TablespaceStatusRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TablespaceStatusService {
    @Autowired
    private TablespaceStatusRepository repository;

    private static List<TablespaceStatus> tablespaceStatusList =  new ArrayList<>();

    @PersistenceContext
    private EntityManager entityManager;

    public List<TablespaceStatus> getAllTablespaces() {
        if(tablespaceStatusList.size() == 0 )
        {
            this.setAllTablespaces();
        }
        return tablespaceStatusList;
    }

    public void setAllTablespaces()
    {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT " );
        sql.append(" 	rownum ID, " );
        sql.append(" 	A.TABLESPACE_NAME tablespace_name, " );
        sql.append(" 	ROUND((A.BYTES-B.FREE)/ 1024 / 1024 / 1024, 2) used_space, " );
        sql.append(" 	ROUND(B.FREE / 1024 / 1024 / 1024, 2) free_space " );
        sql.append(" FROM " );
        sql.append(" 	( " );
        sql.append(" 	SELECT " );
        sql.append(" 		A.FILE_ID , " );
        sql.append(" 		A.TABLESPACE_NAME , " );
        sql.append(" 		A.FILE_NAME , " );
        sql.append(" 		SUBSTR(FILE_NAME, 1, 200) AS FILE_NM, " );
        sql.append(" 		SUM(BYTES) AS BYTES " );
        sql.append(" 	FROM " );
        sql.append(" 		DBA_DATA_FILES A " );
        sql.append(" 	WHERE " );
        sql.append(" 		1 = 1 " );
        sql.append(" 	GROUP BY " );
        sql.append(" 		A.FILE_ID , " );
        sql.append(" 		A.TABLESPACE_NAME , " );
        sql.append(" 		FILE_NAME, " );
        sql.append(" 		SUBSTR(FILE_NAME, 1, 200) " );
        sql.append(" ) A, " );
        sql.append(" 	( " );
        sql.append(" 	SELECT " );
        sql.append(" 		B.TABLESPACE_NAME , " );
        sql.append(" 		B.FILE_ID , " );
        sql.append(" 		SUM(NVL(BYTES, 0)) AS FREE " );
        sql.append(" 	FROM " );
        sql.append(" 		DBA_FREE_SPACE B " );
        sql.append(" 	GROUP BY " );
        sql.append(" 		B.TABLESPACE_NAME, " );
        sql.append(" 		FILE_ID " );
        sql.append(" ) B " );
        sql.append(" WHERE " );
        sql.append(" 	1 = 1 " );
        sql.append(" 	AND A.TABLESPACE_NAME = B.TABLESPACE_NAME " );
        sql.append(" 	AND A.FILE_ID = B.FILE_ID " );
        sql.append(" ORDER BY " );
        sql.append(" 	A.TABLESPACE_NAME " );

        try {
            Query query = entityManager.createNativeQuery(sql.toString(), TablespaceStatus.class);
            tablespaceStatusList = query.getResultList();
            for(TablespaceStatus t : tablespaceStatusList)
            {
                System.out.println(t.getTablespaceName());
                System.out.println(t.getId());
                System.out.println(t.getFreeSpace());
                System.out.println(t.getUsedSpace());
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}