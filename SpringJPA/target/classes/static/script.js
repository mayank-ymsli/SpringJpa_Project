        function submitForm(actionUrl, method) {
            const form = document.getElementById('crudForm');
            const formData = new FormData(form);
            const data = {};

            formData.forEach((value, key) => {
                data[key] = value;
            });

            let url = actionUrl;
            if (method === 'DELETE') {
                url = `${actionUrl}/${data.email}`; // Append the email to the URL for DELETE requests
                delete data.email; // Remove email from the data object as it's included in the URL
            }

            fetch(url, {
                method: method,
                headers: {
                    'Content-Type': method !== 'GET' ? 'application/json' : undefined
                },
                body: method !== 'GET' && method !== 'DELETE' ? JSON.stringify(data) : null
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                console.log('Success:', data);
                if (method === 'GET') {
                    displayRecords(data);
                } else {
                    alert('Operation successful!');
                }
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('There was an error processing your request.');
            });
        }

        function displayRecords(records) {
            const recordsList = document.getElementById('recordsList');
            recordsList.innerHTML = ''; // Clear previous records

            if (!Array.isArray(records) || records.length === 0) {
                recordsList.innerHTML = '<p>No records found.</p>';
                return;
            }

            records.forEach(record => {
                const listItem = document.createElement('div');
                listItem.className = 'list-group-item';
                listItem.textContent = `Name: ${record.name}, Email: ${record.email}`;
                recordsList.appendChild(listItem);
            });
        }