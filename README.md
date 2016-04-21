#Mybatis With Spring Boot

Study project based on spring boot to test some mybatis features with in-memory H2 SQL database.

To run this project you need two console sessions.

In first console session you should run spring boot application
```
./gradlew bootRun
```

From second console session you will query rest API.
In examples below I'm using http://httpie.org for querying.

Do not forget that your working directory have to be in the project folder.

###Basic customers functionality

Let's see all customers created on start
```
http http://localhost:8080/customer/all
```

Adding new customer (will have id=5 for first call)
```
cat jsons/customer.json | http http://localhost:8080/customer/add
```

Get by id
```
http http://localhost:8080/customer/get/1
```

Update customer with id=1
```
cat jsons/customer_1_update.json | http http://localhost:8080/customer/set
```

Check all again
```
http http://localhost:8080/customer/all
```

Find customers by minimum balance with optional match by email
```
http http://localhost:8080/customer/find balance==100
http http://localhost:8080/customer/find balance==-101
http http://localhost:8080/customer/find balance==0 email==dvorets
http http://localhost:8080/customer/find balance==-101 email==banat
```

###Basic links functionality

Get link by id
```
http http://localhost:8080/link/get/1
```

Get links by customer id
```
http http://localhost:8080/link/customer/1
http http://localhost:8080/link/customer/2
```

Add links to customer with id=5 which you should add by command above.
But it does not really matter because customer_id is not FK.
```
http http://localhost:8080/link/customer/5

cat jsons/link_for_5_1.json | http http://localhost:8080/link/add
cat jsons/link_for_5_2.json | http http://localhost:8080/link/add

http http://localhost:8080/link/customer/5
```

###Extended functionality
Get link with related customer
```
http http://localhost:8080/link/get/1
```

Get minimum customer info
```
http http://localhost:8080/link/getbase/1
http http://localhost:8080/link/getbase/5
```

Get extended customer object with all links
```
http http://localhost:8080/customer/getext/1
http http://localhost:8080/customer/getext/5
```

Get extended customer object with extended links
```
http http://localhost:8080/customer/getextext/1
http http://localhost:8080/customer/getextext/5
```

Find all customers matched by name or/and id
```
http http://localhost:8080/customer/findExt id==1 id==2 id==3
http http://localhost:8080/customer/findExt name==ivan id==1 id==2 id==3
http http://localhost:8080/customer/findExt name==ivan id==1 id==3
http http://localhost:8080/customer/findExt name==ivan
```

###JTA test

Note that we change customer_id filed in links first, which is not foreign key.
Than in second query we are trying to change customer id which must be unique.

For more information look into JtaServiceImpl and JtaController.


Let's change customer id from 1 to 111
```
http http://localhost:8080/customer/getext/1
http http://localhost:8080/customer/getext/111

http http://localhost:8080/jta/idupdate/1/111

http http://localhost:8080/customer/getext/1
http http://localhost:8080/customer/getext/111
```

Now change it back
```
http http://localhost:8080/jta/idupdate/111/1

http http://localhost:8080/customer/getext/1
http http://localhost:8080/customer/getext/111
```

Trying change to id which is already exists
```
http http://localhost:8080/customer/getext/1
http http://localhost:8080/customer/getext/2

http http://localhost:8080/jta/idupdate/1/2

http http://localhost:8080/customer/getext/1
http http://localhost:8080/customer/getext/2
```


Valid id update but with exception after successful db updates
```
http http://localhost:8080/customer/getext/1
http http://localhost:8080/customer/getext/111

http http://localhost:8080/jta/idupdaterr/1/111

http http://localhost:8080/customer/getext/1
http http://localhost:8080/customer/getext/111
```