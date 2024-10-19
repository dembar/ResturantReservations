<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Booking Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="my-4">User Bookings Dashboard</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>User Name</th>
                    <th>Table Number</th>
                    <th>Booking Date</th>
                    <th>Number of People</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody id="booking-data">
                <!-- Data will be populated here using Fetch API -->
            </tbody>
        </table>
    </div>

    <script>
        // Fetch API to get booking data from the servlet
        fetch('fetchBookings')
            .then(response => response.json())
            .then(data => {
                let tableBody = document.getElementById('booking-data');
                tableBody.innerHTML = ''; // Clear existing rows

                // Loop through each booking and add rows to the table
                data.forEach(booking => {
                    let row = `<tr>
                                <td>${booking.id}</td>
                                <td>${booking.userName}</td>
                                <td>${booking.tableNumber}</td>
                                <td>${booking.bookingDate}</td>
                                <td>${booking.numberOfPeople}</td>
                                <td>${booking.status}</td>
                               </tr>`;
                    tableBody.innerHTML += row;
                });
            })
            .catch(error => console.error('Error fetching booking data:', error));
    </script>
</body>
</html>
