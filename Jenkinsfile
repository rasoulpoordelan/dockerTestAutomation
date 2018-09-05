pipeline {
   parameters {
      string(name: 'IMAGE_REPO_NAME', defaultValue: '192.168.161.130:50000/myappauto', description: '')
      string(name: 'LATEST_BUILD_TAG', defaultValue: 'build-latest', description: '')
      string(name: 'DOCKER_COMPOSE_FILENAME', defaultValue: 'docker-compose.yml', description: '')
      string(name: 'DOCKER_STACK_NAME', defaultValue: 'my_stack', description: '')
      booleanParam(name: 'PUSH_DOCKER_IMAGES', defaultValue: true, description: '')
    }
    agent any
    stages {

        stage('build')
        {
           environment {
              BUILD_IMAGE_REPO_TAG = "${params.IMAGE_REPO_NAME}:${env.BUILD_TAG}"
            }
            steps{
               sh "docker build . -t $BUILD_IMAGE_REPO_TAG"
            }
        }
    }
}