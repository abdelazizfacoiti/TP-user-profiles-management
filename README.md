# TP-user-profiles-management
This is done as a part of the hiring process challance
#This is a  RESTful endpoint for creating and updating user profiles. 
## The user profile data includes basic information such as name, email, and password, as well as more complex data such as educational background and work experience.
Your task is to implement a custom validation mechanism for the user profile data. The validation rules are as follows:
1.	The name field is required and must be between 2 and 50 characters long.
2.	The email field is required and must be a valid email address.
3. 	The password field is required and must be between 8 and 20 characters long, and must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.
4. 	The education field is optional, but if present, it must be a list of valid educational qualifications (e.g., "Bachelor's Degree in Computer Science").
5. 	The workExperience field is optional, but if present, it must be a list of valid work experience entries (e.g., "Software Engineer at XYZ Inc., 2015-2020").
If any of the validation rules fail, the RESTful endpoint should return an appropriate error message.
You can assume that the user profile data is submitted as a JSON object in the request body.
