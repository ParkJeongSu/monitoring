// scripts.js

// JavaScript code to handle the chart rendering can be added here
// For example, you can use a library like Chart.js to render the charts

// data for showing the line chart

const DiskLabels = diskUsagesList.map ( disk => disk.diskName );
const DiskTotalData = diskUsagesList.map ( disk => disk.usedSpace + disk.freeSpace);
const DiskUsedData = diskUsagesList.map ( disk => disk.usedSpace );
const DiskFreeData = diskUsagesList.map ( disk => disk.freeSpace );



// Creating line chart
let diskChartCanvas = document.getElementById('disk-usage-chart').getContext('2d');
let diskChart = new Chart(diskChartCanvas, {
    type: 'bar',
    data: {
        labels: DiskLabels,
        datasets: [
            {
                label: 'Total (GB)',
                data: DiskTotalData,
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            },
            {
                label: 'Used (GB)',
                data: DiskUsedData,
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            },
            {
                label: 'Free (GB)',
                data: DiskFreeData,
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
         text: 'Disk Usage'
       }
     }
   }
});