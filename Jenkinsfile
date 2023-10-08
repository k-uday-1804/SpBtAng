pipeline{
    agent{
        label "jenkins-agent"
    }
    tools {
        jdk 'Java17'
        maven 'Maven3'
    }
    stages{
        stage("Cleanup Workspace"){
            steps {
                cleanWs()
            }

        }
    
        stage("Checkout from SCM"){
            steps {
                git branch: 'main', credentialsId: 'github', url: 'https://github.com/k-uday-1804/SpBtAng.git'
            }

        }
        stage('Database Query') {
            steps {
                script {
                    def mysqlConnectorVersion = '8.0.23'  // Adjust this version based on your MySQL Connector version
                    
                    def driverUrl = "https://repo1.maven.org/maven2/mysql/mysql-connector-java/${mysqlConnectorVersion}/mysql-connector-java-${mysqlConnectorVersion}.jar"
                    
                    // Download MySQL Connector
                    sh "curl -o mysql-connector-java.jar ${driverUrl}"

                    // Set the classpath to include the MySQL Connector JAR
                    env.CLASSPATH = "${WORKSPACE}/mysql-connector-java.jar:${env.CLASSPATH}"

                    database(
                        driver: 'com.mysql.cj.jdbc.Driver',
                        url: 'jdbc:mysql://18.224.228.225:3306/movie',
                        user: 'movie',
                        password: 'new_password',
                        databaseType: 'MySql',
                        loadFiles: 'mysql-connector-java.jar'  // Load the downloaded MySQL Connector JAR
                    ) {
                        def result = sql(script: 'SELECT * FROM movie')  // Replace 'your_table_name' with your actual table
                        echo result
                    }
                }
            }
        }

        stage("Build Application"){
            steps {
                sh "mvn clean package"
            }

        }

        stage("Test Application"){
            steps {
                sh "mvn test"
            }

        }
    }
}