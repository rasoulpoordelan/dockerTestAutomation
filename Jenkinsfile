pipeline {
   parameters {
      string(name: 'IMAGE_REPO_NAME', defaultValue: '172.16.10.250:50000/myappauto', description: '')
      string(name: 'LATEST_BUILD_TAG', defaultValue: 'build-latest', description: '')
      string(name: 'DOCKER_COMPOSE_FILENAME', defaultValue: 'docker-compose.yml', description: '')
      string(name: 'DOCKER_STACK_NAME', defaultValue: 'my_stack', description: '')
      booleanParam(name: 'PUSH_DOCKER_IMAGES', defaultValue: true, description: '')
    }
    agent any
    stages {

        stage('docker build')
        {
           environment {
              BUILD_IMAGE_REPO_TAG = "${params.IMAGE_REPO_NAME}:${env.BUILD_TAG}"
            }
            steps{
               sh "docker build . -t $BUILD_IMAGE_REPO_TAG"
               sh "docker tag $BUILD_IMAGE_REPO_TAG ${params.IMAGE_REPO_NAME}:${params.LATEST_BUILD_TAG}"
               sh "docker tag $BUILD_IMAGE_REPO_TAG ${params.IMAGE_REPO_NAME}:latest"
            }
        }

         stage('docker push'){
              when{
                expression {
                  return params.PUSH_DOCKER_IMAGES
                }
              }
              environment {
                BUILD_IMAGE_REPO_TAG = "${params.IMAGE_REPO_NAME}:${env.BUILD_TAG}"
              }
              steps{
                sh "docker push $BUILD_IMAGE_REPO_TAG"
                sh "docker push ${params.IMAGE_REPO_NAME}:${params.LATEST_BUILD_TAG}"
                sh "docker push ${params.IMAGE_REPO_NAME}:latest"
              }
            }

          stage('Docker Stack Deploy'){
               steps{
                  sh "docker stack deploy -c ${params.DOCKER_COMPOSE_FILENAME} ${params.DOCKER_STACK_NAME}"
                 }
              }
    }
}
