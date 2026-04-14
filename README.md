#  Plan esencial (6 días) – JUnit + Mockito para mundo real
 
# Fundamentos de testing con JUnit 5

## Objetivo

Entender cómo escribir tests básicos y estructura correcta.

## Lo esencial  

* `@Test`
* `@BeforeEach`
* Assertions:

  * `assertEquals`
  * `assertThrows`
  * `assertTrue`

## Ejercicio

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
}
```

Test:

```java
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void shouldAddNumbers() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }
}
```

## TIP'S

* Tests claros
* Nombres descriptivos (`shouldX_whenY`)
* AAA pattern (Arrange – Act – Assert)
 
 
 
 
----
#  Testing de lógica real (condiciones + errores)

## Objetivo

Probar lógica de negocio (lo que más se testea en backend).

## Conceptos clave

* Validaciones
* Manejo de excepciones
* Edge cases

## Ejercicio

```java
class UserService {
    void register(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email requerido");
        }
    }
}
```

Test:

```java
@Test
void shouldThrowException_whenEmailIsNull() {
    assertThrows(IllegalArgumentException.class, () -> {
        userService.register(null);
    });
}
```

## TIP'S

* Tests de casos negativos ❗
* Validación de errores (MUY importante)









----
# Introducción a Mockito (mockear dependencias)

##  Objetivo

Aislar clases  .

##  Conceptos clave

* `@Mock`
* `@InjectMocks`
* `when(...).thenReturn(...)`

##  Ejercicio

```java
interface UserRepository {
    String findNameById(int id);
}
```

```java
class UserService {
    private UserRepository repo;

    UserService(UserRepository repo) {
        this.repo = repo;
    }

    String getUserName(int id) {
        return repo.findNameById(id);
    }
}
```

Test:

```java
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository repo;

    @InjectMocks
    UserService service;

    @Test
    void shouldReturnUserName() {
        when(repo.findNameById(1)).thenReturn("Juan");

        String result = service.getUserName(1);

        assertEquals("Juan", result);
    }
}
```

##  TIP'S

* Saber mockear DB / APIs
* No depender de infraestructura real













----
# Verificación de comportamiento (verify)

## Objetivo

Validar interacciones (muy usado en entrevistas).

## Conceptos clave

* `verify()`
* `times()`
* `never()`

##  Ejercicio

```java
@Test
void shouldCallRepository() {
    service.getUserName(1);

    verify(repo).findNameById(1);
}
```

## TIP'S

* Saber si tu código llama correctamente a dependencias
* Testing de flujo, no solo resultado










----
# Casos reales (Service + lógica + mocks)

## Objetivo

Simular lógica de negocio real.

##  Ejercicio  

```java
class PaymentService {

    private PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public boolean process(double amount) {
        if (amount <= 0) return false;
        return gateway.pay(amount);
    }
}
```

Test:

```java
@Test
void shouldProcessPayment() {
    when(gateway.pay(100)).thenReturn(true);

    boolean result = service.process(100);

    assertTrue(result);
    verify(gateway).pay(100);
}
```

## TIP'S

* Testing de services ( esto es lo MÁS importante)
* Separación de responsabilidades







----
#  Buenas prácticas  

##  Objetivo

Escribir tests como senior.

##   Debes dominar

* Nombres claros:

  * `shouldReturnX_whenY`
* Evitar lógica en tests
* Test independientes
* No usar datos mágicos
* Uso de builders o factory (opcional)

##   Ejercicio final (mini reto)

Testea esto:

```java
class OrderService {

    private PaymentGateway gateway;

    public OrderService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public String placeOrder(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }

        boolean paid = gateway.pay(amount);

        return paid ? "SUCCESS" : "FAIL";
    }
}
```

👉 Debes cubrir:

* Caso exitoso
* Caso fallo
* Excepción

---

#   Checklist final  

Si sabes esto, ya estás listo:

✅ JUnit 5 annotations
✅ Assertions
✅ assertThrows
✅ Mockito (`@Mock`, `@InjectMocks`)
✅ when / thenReturn
✅ verify
✅ Testear services
✅ Casos positivos y negativos

---

# Bonus 

Si quieres subir de nivel después:

* `@SpringBootTest` (integración)
* `Testcontainers`
* `MockMvc`
* Coverage (JaCoCo)

 


