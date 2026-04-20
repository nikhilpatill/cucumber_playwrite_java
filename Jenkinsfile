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
                bat 'mvn clean install -Dmaven.test.failure.ignore=true'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }
}