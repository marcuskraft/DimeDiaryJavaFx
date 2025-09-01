# DimeDiaryFX

DimeDiaryFX is a standalone JavaFX application for managing personal finances. It offers a simple, desktop-based
solution for tracking income and expenses and gaining control over your financial life. This project uses an embedded,
file-based database to ensure your data persists across multiple sessions without the need for an external database
server.

---

## Getting Started 🚀

These instructions will guide you through running the application on your local machine.

### Prerequisites

You need the following software installed to run this project:

* **Java (JDK) 21**
* **Apache Maven 3.x**

To ensure Maven uses the correct Java version, you need to configure a toolchain. Create a file named **`toolchains.xml`
** in your Maven settings directory (`~/.m2/` on Linux/Mac or `%USERPROFILE%\.m2\` on Windows) with the following
content. **Adjust the path to your java 11.**

    ```xml
    <toolchains>
      <toolchain>
        <type>jdk</type>
        <provides>
          <version>21</version>
          <vendor>oracle</vendor>
        </provides>
        <configuration>
          <jdkHome>/path/to/your/jdk-21</jdkHome>
        </configuration>
      </toolchain>
    </toolchains>
    ```

---

## Building the Application

1. Navigate to `Dimediary/` folder.
2. Use Maven to build the application and create the executable JAR file. This command will resolve all dependencies and
   create a single, bundled JAR.
   ```bash
   mvn clean package
   ```

---

## Running the Application

After a successful build, you can find the executable JAR file in the `Build/target/` directory.

1. Open a terminal or command prompt.
2. Navigate to the `Build/target/` folder.
3. Execute the JAR file using the following command:
   ```bash
   java -jar DimeDiary-0.4.1-jar-with-dependencies.jar
   ```

### Database

The application uses an embedded **Apache Derby** database. On the first run, it will automatically create a `DB/`
folder in the parent directory of the executable JAR file. This folder stores all your data, ensuring it remains
persistent even after you close and restart the application.