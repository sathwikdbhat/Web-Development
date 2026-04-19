document.addEventListener('DOMContentLoaded', () => {
    
    // --- 1. USER LOGIN & MEMORY ---
    const body = document.body;
    const name = localStorage.getItem('user_name'); // Get saved name
    const welcomeMsg = document.getElementById('welcome-message');

    // If name exists, hide the login box and show a welcome message
    if (name) {
        document.getElementById('login-modal').style.display = 'none';
        welcomeMsg.innerHTML = `<span>Welcome, ${name}!</span>`;
    }

    // Save the name when the user submits the login form
    document.getElementById('modal-login-form').onsubmit = (e) => {
        localStorage.setItem('user_name', document.getElementById('modal-name-input').value);
    };

    // --- 2. THE APP REFRESHER (Stats & Streak) ---
    const refreshApp = () => {
        // Count total checkboxes and how many are checked
        const cb = document.querySelectorAll('.topic-checkbox');
        const checked = document.querySelectorAll('.topic-checkbox:checked').length;
        
        // Update the numbers on the Dashboard
        document.getElementById('total-topics').textContent = cb.length;
        document.getElementById('completed-count').textContent = checked;

        // Get today's date and the last time the user was active
        const today = new Date().toDateString();
        const last = localStorage.getItem('last_date');
        let streak = parseInt(localStorage.getItem('streak_count')) || 0;

        // If today is a new day, check if it continues the streak
        if (last !== today) {
            const yesterday = new Date();
            yesterday.setDate(yesterday.getDate() - 1); // Go back 1 day
            
            // If last visit was yesterday, streak +1; otherwise, reset to 1
            streak = (last === yesterday.toDateString()) ? streak + 1 : 1;
            
            localStorage.setItem('streak_count', streak); // Save new streak
            localStorage.setItem('last_date', today);      // Save today's date
        }
        // Show the streak on the Dashboard
        document.querySelector('.stat-card:last-child .stat-number').textContent = `${streak} Days 🔥`;
    };

    // --- 3. CHECKBOX SAVING ---
    document.querySelectorAll('.topic-checkbox').forEach(cb => {
        // Load the saved "checked" status from browser memory
        cb.checked = localStorage.getItem(cb.dataset.key) === 'true';
        
        // When clicked, save the status and update the dashboard
        cb.onchange = () => {
            localStorage.setItem(cb.dataset.key, cb.checked);
            refreshApp();
        };
    });

    // --- 4. NAVIGATION & SIDEBAR ---
    document.querySelectorAll('.nav-link').forEach(link => {
        link.onclick = () => {
            // Hide all sections, then show the one that was clicked
            document.querySelectorAll('.content-section').forEach(s => s.classList.remove('active-section'));
            document.getElementById(`${link.dataset.section}-section`).classList.add('active-section');
        };
    });

    
});