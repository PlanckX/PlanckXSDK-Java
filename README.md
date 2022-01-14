
# PlanckX SDK for Java

[![License](https://img.shields.io/badge/License-MIT-green)](https://raw.githubusercontent.com/PlanckX/PlanckXSDK-Java/master/LICENSE)

## Welcome to the PlanckX Studio SDK！
> The PlanckX Studio SDK contains the basic SDK tools. You can embed the SDK into your game creation to support the mint and issuance of NFT (Non-fungible-token) assets in your game creation, Match the PlanckX platform account with your game account, And link the NFT assets holder（Usually the player who bought the NFT） by the asset owner to the game for use.


## First step:
> * Go to the **[PlanckX Studio](https://studio.planckx.io)** to register.
> * Get **APIKey** and **SecretKey**.
## Second step:
> * Install library into your Maven's local repository by running `mvn install`
> * Add the following Maven dependency to your project's `pom.xml`:
```
    <dependency>
      <groupId>io.planckx.api</groupId>
      <artifactId>planckx-api-client</artifactId>
      <version>1.0</version>
    </dependency>
```
## Example Usage
> * This example check a game player is bound to a PlanckX account:
```java
    String apiKey = "Go to the PlanckX studio website to get";
    String secretKey = "Go to the PlanckX studio website to get";
    PlanckXAccountClient accountClient = 
            PlanckXClientFactory.newInstance(apiKey, secretKey).newAccountClient();
    
    accountClient.bindStatus("Player ID");
    
    // Process your bussiness ....
```
> * This example gets NFT assets:
```java
    String apiKey = "Go to the PlanckX studio website to get";
    String secretKey = "Go to the PlanckX studio website to get";
    PlanckXNftClient nftClient = 
            PlanckXClientFactory.newInstance(apiKey, secretKey).newNftClient();
    
    // Get all Nfts
    nftClient.getAllNfts();
    
    // Get a player's Nfts
    nftClient.getNftsByPlayer("Player ID");
    
    // Get Nft by TokenId
    nftClient.getNftById("Token Id");
    
    // Process your bussiness ....
```
## Other
> * Supports JDK 1.8+