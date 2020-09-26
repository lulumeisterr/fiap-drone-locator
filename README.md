# INTEGRATIONS-DEVELOPMENT-TOOLS

  Desenvolva uma solução para o agronegócio que coleta dados via sensores de temperatura
  e umidade. Esses sensores ficarão instalados em um drone com uma altíssima autonomia
  de energia, pois conta com pequenos, porém muito eficientes painéis fotovoltaicos.
  A cada 10 segundos são enviados para o message broker os dados de temperatura e
  umidade capturado naquele instante.
  Além da primeira função também é possível acionar o rastreamento do drone. Esta
  funcionalidade resulta na localização do equipamento em um mapa.

# Imagem RabbitMQ

Instale a imagem do RabbitMQ com docker

  - docker run -d -p 15672:15672 -p 5672:5672 --name rabbitmq rabbitmq:3-management
  - docker exec -it rabbitmq bash -> Ativar o plugin para poder mover mensagens para outras filas 
  	- $ rabbitmq-plugins enable rabbitmq_shovel rabbitmq_shovel_management
  
Painel do RabbitMQ
  - http://localhost:15672/#/
  
  - user e password : guest
  
# H2
    - Macos : jdbc:h2:~/fiapstockdatabase;DB_CLOSE_ON_EXIT=FALSE
    - Windows : jdbc:h2:file:/home/#userexemplo/fiapstockdatabase
    - H2 Console : http://localhost:8081/h2-console/
  
# EndPoint para publicar na fila

- localhost:8001/send
- Body / Method Post

      {
      "text" : {
        "temperatura" : 20.0,
        "umidade" : 10.0
       }
      }
    
# Usando o Exchange Direct 

- Ao Executar o projeto as filas sao criadas automaticamente
- Criacao do exchange do tipo direct que recebe a mensagem enviada pelo produtor e encaminha a mensagem para a fila destinada do produtor.
