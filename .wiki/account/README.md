Account Endpoint
================
--------------------
|Method|Description|Parameters|
|------|-----------|----------|
|GET   |Get basic account information on the passed in userId or sessionId|Requires one of the following:<br/>- userId<br/>- sessionId
|DELETE|Deletes the given account|Requires all of the following:<br/>- sessionId<br/>- email<br/>- password
|PUT   |Updates the given account with the provided information|Requires one of the following:<br/>- userId<br/>- sessionId<br/>Requires any of the following:<br/>- firstName<br/>- lastName<br/>- password
