// scripts.js

// JavaScript code to handle the chart rendering can be added here
// For example, you can use a library like Chart.js to render the charts

// data for showing the line chart

var memoryDataFormatList = memoryUsageList.map(function(item) {
    return {
        x: formatTimestamp(item.timestamp),
        y: item.usage
    };
});


// Creating line chart
let memoryChartCanvas = document.getElementById('memory-usage-chart').getContext('2d');
let memoryChart = new Chart(memoryChartCanvas, {
    type: 'line',
    data: {
        datasets: [
            {
            label: 'Momory Usage',
            data: memoryDataFormatList,
            borderColor: 'rgba(75, 192, 192, 1)',
            borderWidth: 1,
            fill: false
            }
        ]
    },
    options: {
        responsive: true,
        scales: {
            x: {
                title: {
                    display: true,
                    text: 'time',
                    font: {
                        padding: 4,
                        size: 20,
                        weight: 'bold',
                        family: 'Arial'
                    },
                    color: 'darkblue'
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'Memory Usage',
                    font: {
                        size: 20,
                        weight: 'bold',
                        family: 'Arial'
                    },
                    color: 'darkblue'
                },
                beginAtZero: true,
                scaleLabel: {
                    display: true,
                    labelString: 'Values',
                }
            }
        }
    }
});