# Premium Travel - OOD
Collaboration for OOD Project

## Run server
### 1. Install Java 8
- [Download Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- Install  
- [Add Java to the PATH](https://www.java.com/en/download/help/path.xml)

### 2. Install Maven
- [Download Maven](https://maven.apache.org/download.cgi)
- Install
- [Add Maven to the PATH](https://www.mkyong.com/maven/how-to-install-maven-in-windows/)

### 3. Install Java EE
- [Download Java EE](https://www.oracle.com/technetwork/java/javaee/downloads/index.html) (not the Web Profile)
- Unzip
- Move the folder to desired location. **Make sure there are no spaces in the path**.
- [Configure Glassfish to use Java](https://stackoverflow.com/questions/10444959/how-do-i-specify-the-jdk-for-a-glassfish-domain)
- [Add Glassfish to the PATH](https://docs.oracle.com/cd/E19575-01/821-0186/fvjgo/index.html)

### 4. Run Server
- Navigate the command line to the "server" directory within the project.
- Execute ```mvn package```
- Start glassfish with ```asadmin start-domain```
- Deploy the Maven-produced package by moving *project_dir*\server\target\premium-travel-backend.war to *glassfish_install_dir*\glassfish\domains\\*domain*\autodeploy\
