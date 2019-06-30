PORT => 5433

MANUAL
mvn install:install-file -DgroupId=net.sf.jt400 -DartifactId=jt400 -Dversion=9.4 -Dpackaging=jar -Dfile=C:/lib_download/jt400.jar
<dependency>
        <groupId>net.sf.jt400</groupId>
        <artifactId>jt400</artifactId>
        <version>9.4</version>
</dependency>

MANUAL
mvn install:install-file -DgroupId=net.sf.jt400 -DartifactId=jt400 -Dversion=9.4 -Dpackaging=jar -Dfile=C:\lib_download\jt400-9.4.jar
<dependency>
        <groupId>net.sf.jt400</groupId>
        <artifactId>jt400-9.4</artifactId>
        <version>9.4</version>
</dependency>


MANUAL
mvn install:install-file -DgroupId=com.ibm.db2 -DartifactId=db2jcc4 -Dversion=unknown -Dpackaging=jar -Dfile=C:\lib_download\db2jcc4.jar
<dependency>
        <groupId>com.ibm.db2</groupId>
        <artifactId>db2jcc4</artifactId>
        <version>unknown</version>
</dependency>
MANUAL
mvn install:install-file -DgroupId=com.ibm.db2 -DartifactId=db2jcc -Dversion=unknown -Dpackaging=jar -Dfile=C:\lib_download\db2jcc.jar
<dependency>
        <groupId>com.ibm.db2</groupId>
        <artifactId>db2jcc</artifactId>
        <version>unknown</version>
</dependency>


MAVEN
<!-- https://mvnrepository.com/artifact/com.ibm.db2.jcc/db2jcc4 -->
<dependency>
    <groupId>com.ibm.db2.jcc</groupId>
    <artifactId>db2jcc4</artifactId>
    <version>10.1</version>
</dependency>

----wkhtmltopdf----
Path => C:\Program Files\wkhtmltopdf\bin
$ cd Downloads
$ wkhtmltopdf C:\Users\detectortroyano\git\integrity-demo\load-file-clean.html C:\Users\detectortroyano\Downloads\load-file-clean.pdf
$ wkhtmltopdf http://google.com google.pdf
$ wkhtmltopdf -O landscape http://google.com C:\Users\detectortroyano\Downloads\google.pdf              #Horizontal
$ wkhtmltopdf -B 15 -L 15 -R 15 -T 15 http://google.com C:\Users\detectortroyano\Downloads\google.pdf   #Margenes

java -jar C:\lib_service\ConvertHtmlToPDF.jar "https://www.google.com/" "C:\\Users\\detectortroyano\\Downloads\\" "google.pdf" ""
java -jar C:\lib_service\ConvertHtmlToPDF.jar "https://www.google.com/" "C:\\Users\\detectortroyano\\Downloads\\" "google.pdf" "-O landscape -B 15 -L 15 -R 15 -T 15"


----CAMBIAR CONTRASEÑA IBM----
CHGUSRPRF USRPRF(USERNAME) STATUS(*ENABLED)
CHGUSRPRF USRPRF(USERNAME) PASSWORD(PASSWORD)

----JAVA CONFIG----
# PROJECT DEPLOYMENT ECLIPSE
1.- Configuration eclipse with JDK
- Click **Windows** tab > Click **Preferences** >
- Click **Java** > Click **Installed JRes** >
- Click **Add** button > Choose **Standard VM** > Click **Next** button > Choose **root directory JAVA JDK** > Click **Finish** button.
Example **root directory JAVA JDK** : C:\Program Files\Java\jdk1.8.0_40
2.- Right click project > Click **Run As** > Click **Maven Install**
3.- Check jar in **target / filename.jar**

# PROJECT JAVA JDK
1.- Check if project run with JDK 
- Click **Project** > Properties
- Choose Java Build Path > Libraries > Edit JRE Sistem Library if there is not JAVA JDK root directory
Example **root directory JAVA JDK** : C:\Program Files\Java\jdk1.8.0_40


#INSTALL MAVEN CMD
1.- Download maven bin in C for run comand line
2.- Set apache maven directory in C
3.- Set maven directory in **path** environment. Example: C:\apache-maven-3.5.0\bin

# ADD JT400 LIBRARY
1.- Download jt400 9.4 version
2.- Add libray to maven repository
    mvn install:install-file -DgroupId=net.sf.jt400 -DartifactId=jt400 -Dversion=9.4 -Dpackaging=jar -Dfile=C:/lib_download/jt400.jar

# CREATE RUNNABLE JAR FILE
1.- Click rigth to project > **Run as** > **Maven clean**
2.- Click rigth to project > **Run as** > **Maven install**
3.- Click rigth to project > Run as > Run Configurations..
3.1.- Choose Java Application > New > set Name > set Project > set Main Class
3.2.- Choose Run button
4.- Click rigth to project > Choose **Export**
4.1- Choose **Java** > **Runnable Jar File** > Next
4.2.- Choose **directory to export** and set **name** (C:\lib_service\ListenerDirectory.jar)
4.3.- Choose **Packaged required libreries into generated jar**
5.- Click in **Finish**

# CREATE TASK
1.- **Win + R**
2.- Write **taskschd.msc**
3.- **Enter**
4.- In **Programador de Tareas**
5.- Click in **Crear una Tarea**
6.1.- In **General**:
- Write **Nombre**(ListenerDirectory) and **Descripcion**(Listener directory, send files directory by email and move to historic folder.).
- Choose **Ejecutar tanto si el usuario a iniciado sesion como si no**.
- Check in **Ejecutar con los privilegios mas altos**.
- Finally choose in **para Windows 10**.

6.2.- In **Desencadenadores**
- Click in **Nuevo**.
- In **Nuevo Desencadenador** chosse **Iniciar la tarea Segun una programacion**.
- Choose **Configuracion Diariamente**.
- Check in **Repetir cada 1 hora durante 12 horas**.
- Finally click in **Aceptar**.

6.3.- In **Acciones**:
- Click in Nueva.
- In **Nueva Accion** choose **Accion Iniciar un programa**.
- In **Configuracion** choose **Runable Jar**
- File(C:C:\lib_service\ListenerDirectory.jar).
- In **arguments** set email destination, source directory, target directory.
- Example set "krescruz@gmail", "C:\\directory\\", "C:\\directory_history\\".
- Finally click in **Aceptar**.

7.- Finally click in **Aceptar** and write **password**.

----TASK MANAGER----
--Automatico
    taskschd.msc
    "angelricardo.uthh@gmail.com" "C:\\directory\\" "C:\\directory_history\\"
--Manual
    java -jar file.jar "angelricardo.uthh@gmail.com" "C:\\directory\\" "C:\\directory_history\\"
    java -jar C:\lib_service\integrity-report-auxjava-0.0.1-SNAPSHOT.jar
    java -jar C:\lib_service\gs-rest-service-0.1.0.jar

# DEPLOY APACHE TOMCAT
1.- Download Apache Tomcat 8.5.32
1.2 Got to https://tomcat.apache.org/download-80.cgi 
1.3 Choose File 64-bit Windows zip
2.- Extract rar and set apache-tomcat-8.5.32 directory in C
3.- Set war file in apache-tomcat-8.5.32\webapps
4.- Got to apache-tomcat-8.5.32\bin and click in startup.bat(Windows)
5.- For shutdown web aplicattion Click in shutdown.bat(Windows)
