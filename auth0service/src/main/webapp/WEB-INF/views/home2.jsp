<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home - E-commerce</title>
  <style>
	body {
	  font-family: Arial, sans-serif;
	  margin: 0;
	  padding: 0;
	}

	.navbar {
	    position: absolute;
	    top: 0;
	    right: 0;
	    width: 100%;
	    background-color: #333;
	    padding: 10px;
	}

	.navbar ul {
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
	    display: flex;
	    flex-direction: row;
		justify-content: flex-end
	}

	.navbar ul li {
	    margin-left: 20px;
	}

	.navbar ul li a {
	    text-decoration: none;
	    color: white;
	    padding: 10px;
	    font-size: 16px;
	}

	.navbar ul li a:hover {
	    background-color: #575757;
	    border-radius: 5px;
	}


	.hero {
	  background-color: #f4f4f4;
	  padding: 20px;
	  text-align: center;
	}

	.products {
	  padding: 20px;
	}

	.product-grid {
	  display: flex;
	  gap: 20px;
	  justify-content: space-around;
	}

	.product {
	  border: 1px solid #ddd;
	  padding: 10px;
	  text-align: center;
	}

	.product img {
	  max-width: 100%;
	  height: auto;
	}

	
  </style>
  </head>
<body>
	<nav class="navbar">
	    <ul>
	        <li><a href="/home">Home</a></li>
	        <li><a href="/categories">Categories</a></li>
	        <li><a href="/cart">Cart</a></li>
	        <li><a href="/orders">Orders</a></li>
			<li><a href="/login">Login</a><li>
			<li><a href="/register">Register</a><li>
	     </ul>
	</nav>


  <section class="hero">
    <h1>Welcome to Our E-commerce Store</h1>
    <p>Shop the latest products across various categories!</p>
  </section>

  <section class="products">
    <h2>Featured Products</h2>
    <div class="product-grid">
      <div class="product">
        <img src="src/main/resources/static/images\redmi.jpeg" alt="Product 1">
        <h3>Redmi Note 12 Pro+</h3>
        <p>Price: $100</p>
        <a href="/product/1">View Details</a>
      </div>
      <div class="product">
        <img src="src/main/resources/static/images/vivo-mobile-phone.jpg" alt="Product 2">
        <h3>Vivo Y100</h3>
        <p>Price: $150</p>
        <a href="/product/2">View Details</a>
      </div>
      <!-- Add more products here -->
    </div>
  </section>

</body>
</html>
