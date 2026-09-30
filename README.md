# hello-world-api

Small Spring Boot service with one endpoint:

```
GET /hello-world?name=alice
```

- name starts with A-M (any case): `200` `{"message": "Hello Alice"}`
- name starts with N-Z: `400` `{"error": "Invalid Input"}`
- name missing or empty: `400` `{"error": "Invalid Input"}`

## Run

Needs JDK 17+ and Maven.

```
mvn spring-boot:run
curl "http://localhost:8080/hello-world?name=alice"
```

## Test

```
mvn test
```

## Assumptions

- Surrounding whitespace in `name` is ignored; a blank name counts as empty.
- The first character has to be an English letter. Anything else (digits, symbols, accented letters) gets a `400`.
- Only the first letter is capitalised in the greeting, the rest of the name is left as is.
