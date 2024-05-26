// scripts.js

// JavaScript code to handle the chart rendering can be added here
// For example, you can use a library like Chart.js to render the charts

// data for showing the line chart

const tableLabels = tablespaceList.map ( table => table.tablespaceName );
const tableTotalData = tablespaceList.map ( table => table.usedSpace + table.freeSpace);
const tableUsedData = tablespaceList.map ( table => table.usedSpace );
const tableFreeData = tablespaceList.map ( table => table.freeSpace );



// Creating line chart
let tableChartCanvas = document.getElementById('tablespace-chart').getContext('2d');
let tableChart = new Chart(tableChartCanvas, {
    type: 'bar',
    data: {
        labels: tableLabels,
        datasets: [
            {
                label: 'Total (GB)',
                data: tableTotalData,
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            },
            {
                label: 'Used (GB)',
                data: tableUsedData,
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            },
            {
                label: 'Free (GB)',
                data: tableFreeData,
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }
        ]
    },
    options: {
     responsive: true,
     plugins: {
       legend: {
         position: 'top',
       },
       title: {
         display: true,
         text: 'table Usage'
       }
     }
   }
});