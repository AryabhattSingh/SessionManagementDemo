# Session Management Demo

This project demonstrates how session management works within a web application. The main goal is to illustrate how session data can be shared across different components or pages within the same user's session and browser.

## Overview

In this demo, we have created a simple web application that showcases session management using Java servlets. The process involves capturing a user's input, storing it in a session, and then retrieving and displaying it on a subsequent page.

## How it Works

1. **User Input Form** (`User.html`):
   - The user starts by accessing the `User.html` page.
   - This page presents an HTML form where the user can enter their username.

2. **Source Servlet** (`SourceServlet.java`):
   - When the user submits the form, the data is sent to the `SourceServlet.java` servlet.
   - The servlet reads the username from the request parameters.
   - It retrieves the HttpSession object associated with the current user's session.
   - The username is then stored within the session object.

3. **HTML Generation and Link**:
   - After storing the username in the session, the `SourceServlet` generates an HTML response.
   - The HTML includes a hyperlink that directs the user to the next step.

4. **Target Servlet** (`TargetServlet.java`):
   - When the user clicks the hyperlink, the request is sent to the `TargetServlet.java` servlet.
   - The `TargetServlet` retrieves the username from the session, which was previously set by the `SourceServlet`.
   - The retrieved username is then displayed to the end user.

## Key Takeaways

- This demo emphasizes the concept of session management within web applications.
- A user's session data can be maintained across different components or pages, as long as the requests are coming from the same user and the same browser.
- The HttpSession object is used to store and retrieve session-specific data.
- This approach is useful for maintaining user-specific data across multiple interactions with the web application.
- This project also shows the use of `Cookies` and how they can be used to exchange data between the web server and the web client. In Java EE, The name of the cookie that is used for session management is `JSESSIONID`.
- If your web browser doesn't support cookies or you have disabled cookies, this project demonstrates `URL Rewriting` as well to showcase session management.
- This project includes `Hidden Form Fields` (commented out). In this method, we create a hidden form that passes the control to the
  servlet whose path is given in the action attribute of <form>.

## Running the Demo

1. Clone this repository to your local machine.
2. Deploy the project on a Java servlet container (e.g., Apache Tomcat).
3. Access the `User.html` page through your web browser.
4. Enter a username and submit the form.
5. Click the provided hyperlink to navigate to the `TargetServlet`, where the stored username will be displayed.

Feel free to explore the code in this repository to understand the implementation details of session management in Java servlets.

## Disclaimer

This project is intended for educational purposes to demonstrate session management concepts. It is not meant for production use without appropriate security measures and best practices.
