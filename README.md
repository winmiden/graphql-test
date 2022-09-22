# Spring for GraphQL CRUD + Testing

This repository contains code for the following YouTube videos: 

- [GraphQL CRUD Java](https://youtu.be/AgSO3rcSuHE)
- [GraphQL API Testing](https://youtu.be/0b0x3C_BTT8)

http://localhost:8080/graphiql?path=/graphql

query {
  findAllProducts {
    id
    productName
  }
}

mutation {
  createProduct(productName: "test 1") {
    id
  }
}

