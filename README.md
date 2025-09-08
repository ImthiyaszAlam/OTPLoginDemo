

# OTP Login Demo - Android

A simple **Android application** demonstrating **Email OTP (Passwordless) authentication** using **Firebase Authentication**, with a clean **Activity-based flow** and a **Dashboard screen**. Built in **Kotlin**, following modern Android development practices.

---

##  Features

- **Email-based OTP Authentication** (Passwordless sign-in)  
- **Activity-based navigation** (Login → Dashboard)  
- **Persistent session management** (auto-login if user already signed in)  
- **Logout functionality**  
- **Material Design UI** for smooth user experience  
- Fully tested with **Firebase Authentication Email Link**

---

##  Screens

1. **LoginActivity**  
   - User enters email  
   - Sends OTP via Firebase  
   - Stores email locally for verification  

2. **DashboardActivity**  
   - Welcomes logged-in user  
   - Provides a **Logout button**  

---

##  Technology Stack

- **Kotlin** – Modern Android programming language  
- **Firebase Authentication** – Email OTP (Passwordless)  
- **AndroidX** – Core libraries & Lifecycle components  
- **Material Design** – UI/UX  
- **SharedPreferences** – Local email storage  

---

## How It Works

1. User enters email → Firebase sends OTP link.
2. User clicks the link in email → App opens via **deep link**.
3. `LoginActivity` verifies link → User is logged in.
4. Redirected to **DashboardActivity**.
5. User can **logout**, returning to Login screen.

---

## Key Learnings & Skills Demonstrated

* Firebase **Email OTP Authentication**
* Handling **deep links** in Android
* Activity-based **navigation flow**
* Persistent login using **SharedPreferences**
* Material Design UI and **modern Kotlin patterns**


