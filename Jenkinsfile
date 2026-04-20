pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/nikhilpatill/cucumber_playwrite_java.git', branch: 'master'
            }
        }

        stage('Check Java Version') {
            steps {
                bat 'java -version'
            }
        }

        stage('Build') {
            steps {
                dir('/PlaywrightJavaCucumberTestNG-master') {
                    bat 'mvn clean package -Dmaven.test.failure.ignore=true'
                }
            }
            post {
                success {
                    junit 'PlaywrightJavaCucumberTestNG-master/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'Playwright-Java-PageObjectModel-master/target/*.jar'
                }
            }
        }

        stage("Deploy to QA") {
            steps {
                echo "Deploying to QA..."
            }
        }

        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    dir('PlaywrightJavaCucumberTestNG-master') {
                        bat 'mvn clean test -Dsurefire.suiteXmlFiles=/PlaywrightJavaCucumberTestNG-master/testng.xml'
                    }
                }
            }
        }

        
    }
}