[![NPM](https://img.shields.io/npm/l/react)](https://github.com/lucarauj/Email-Service-com-Java-Spring/blob/main/LICENSE)

<h1 align="center">Email Service com Java, Spring e Amazon SES</h1>

<br>

## Dependências

- Spring Web
- Lombok
- AWS Java SDK For Amazon SES

<br>

## Anotações

- [@Bean](https://github.com/lucarauj/Anotacoes-Spring-Framework)
- [@Configuration](https://github.com/lucarauj/Anotacoes-Spring-Framework)
- [@PostMapping](https://github.com/lucarauj/Anotacoes-Spring-Framework)
- [@RequestBody](https://github.com/lucarauj/Anotacoes-Spring-Framework)
- [@RequestMapping](https://github.com/lucarauj/Anotacoes-Spring-Framework)
- [@RestController](https://github.com/lucarauj/Anotacoes-Spring-Framework)
- [@Service](https://github.com/lucarauj/Anotacoes-Spring-Framework)

<br>

## Configurando o Amazon SES

<br>

- Amazon Simple Email Service
- Identidades verificadas
- Criar identidade
- Endereço de e-mail
- Criar identidade

<hr>

- IAM
- Usuários
- Criar usuário
- Anexar políticas diretamente
- AmazonSESFullAccess
- Criar chave de acesso
- Aplicação em execução em um serviço computacional da AWS
- Definir etiqueta de descrição (opcional)

<br>

## Configurando application.properties

```
aws:
accessKeyId:********************
secretKey:**********************
region:us-east-1
```

<br>

## Alterações no código

<br>

- Antes
```
@Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        return AmazonSimpleEmailServiceClientBuilder.standard().build();
    }
```
- Depois
```
@Bean
    public AmazonSimpleEmailService amazonSimpleEmailService(
            @Value("${accessKeyId}") String accessKeyId,
            @Value("${secretKey}") String secretKey) {

        AWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretKey);

        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
```

<br>
<hr>
<br>

<p align="left"><img width="800px" src="https://github.com/lucarauj/Email-Service-com-Java-Spring/blob/main/images/Postman.png" /></p>
<p align="left"><img width="600px" src="https://github.com/lucarauj/Email-Service-com-Java-Spring/blob/main/images/Gmail.png" /></p>

<br>

# 👨🏼‍🎓 Aluno

Lucas Araujo

<a href="https://www.linkedin.com/in/lucarauj"><img alt="lucarauj | LinkdeIN" width="40px" src="https://user-images.githubusercontent.com/43545812/144035037-0f415fc7-9f96-4517-a370-ccc6e78a714b.png" /></a>
