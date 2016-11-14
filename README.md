# springboot-security-jwt
Secure your API with JWT Tokens

#Run App

mvn spring-boot:run


## Get token

localhost:8080/api/auth/login -H X-Requested-With: XMLHttpRequest

```json
{
    "username": "demo",
    "password": "demo"
}
```

## Profile

localhost:8080/api/me -H X-Authorization: ${TOKEN_OBTAINED_PREVIOUSLY}

```json
{
  "username": "demo",
  "authorities": [
    {
      "authority": "ROLE_ADMIN"
    }
  ]
}
```