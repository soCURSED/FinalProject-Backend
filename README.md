#** E-commerce Backend Final Project**

I have fininshed the Backend part in Tuwaiq FullStack Bootcamp, in this project I put all the knolage and skills I gain there. 
The project is called E-commerce Backend, it is a backend system with over 16 end points. There is a User, Cart and Product.

**User:**
- Register
- Login
- Get all users
- Get user by Id
- Update user
- Delete user
- Add cart to user
- Add product to user's cart

**Cart:**
- Get all carts
- Get cart by Id
- Update cart payment method
- Delete cart

**Product:**
- Get all products
- Get product by product Id
- Update product
- Delete product


###**All endpoints: **

**User:**
-userId:Integer
-username:String
-userPassword:String
-userEmail:String
-userRole:String
-userAddress:String
-userPhone:String

+getAllUser()
+getUserById(Integer userId)
+Register(User user)
+updateUser(userId:Integer,user:User)
+deleteUser(userId:Integer)
+addCartToUser(cartDTO:CartDTO)
+addProductToUser(productDTO:ProductDTO) 
+login(userId:Integer)


**Cart:**
-CartId:Integer
-paymentMethod:String 

+getCart()
+getCartById(cartId:Integer)
+updateCart(cartid:Integer,cart:Cart) 
+deleteCart(cartId:Integer) 



**Product:**
-productId:Integer
-productName:String
-productType:String

+getAllProduct()
+getProductById(productId:Integer)
+updateProduct(productId:Integer,product:Product)
+deleteProduct(productId:Integer)

#**Class Diagram:**
![chrome_2aIAdA5qyc](https://user-images.githubusercontent.com/45186916/173199296-4588ec11-5724-4df5-bede-7cf333d501f0.png)



###**Project requirements:**
- At least 10 endpoints
- At least 3 table relationships
- Include all CRUD operations (Create, Read, Update, Delete)
- Login & register
- Hosted on heroku

###**Dependancies:**
- Spring web
- Project lombock
- Validation
- JPA
- Spring security
- MySQL

###**Layers used:**
- Controller layer
- Service layer
- Repository layer
- Advice layer
- DTO
- Security
