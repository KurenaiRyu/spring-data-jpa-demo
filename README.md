# Spring Data JPA Demo
添加了Hibernate的MetaModel生成器，并整合了一下lombok，主要想试一下JPA复杂查询。  

## Getting Started
因为MetaModel生成器原因，需要先用maven编译一次得到MetaModel类
```shell script
mvn compile
```
或是通过IDE生成  

pgdb docker-compose:
```yaml
version: '3.7' # specify docker-compose version

services:
  test-pgdb:
    image: postgres
    ports:
      - "5432:5432"
    restart: always
    environment:
      POSTGRES_PASSWORD: password
      POSTGRES_DB: test
      POSTGRES_USER: user
    volumes:
      - ./data:/var/lib/postgresql
```
## Reference
[helidon-sample](https://github.com/hantsy/helidon-sample/blob/master/mp-jpa/src/main/java/com/example/PostRepository.java) @ [hantsy](https://github.com/hantsy)