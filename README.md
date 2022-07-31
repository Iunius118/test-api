# test-api

A test api for Forge mod.

## Setup
### build.gradle
#### Repositories
```gradle
repositories {
  maven {
    url 'https://iunius118.github.io/test-api/maven'
  }
}
```

#### Dependencies
```gradle
dependencies {
  implementation fg.deobf("com.github.iunius118:test-api:${test_api_version}")
}
```

### gradle.properties
```properties
test_api_version=1.0.0
```

## Sample
```java
@Mod("apitestmod")
public class APITestMod {
    public APITestMod() {
        // Sample method called on PlayerLoggedInEvent
        Consumer<PlayerEvent.PlayerLoggedInEvent> method = e -> {
            Player player = event.getEntity();
            player.sendSystemMessage(Component.literal("Hi, ").append(player.getDisplayName()).append("!").withStyle(ChatFormatting.GOLD));
        };
        
        // Resister the method to API
        TestAPI.registerMethod(method);
    }
}
```

See also https://github.com/Iunius118/APITestMod
