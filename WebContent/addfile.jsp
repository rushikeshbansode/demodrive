<html>

  <head>

      <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/addfile.css">
  </head>
  <body class="backcolour">

      <!-----------------------------HEADER enterproduct.html-------------->
        <div>
          <div class="topheader">
    				<button type="submit" id="homebtn"><a href="login.html"><b>HOME</b></button></a>
            <a href="login.html"><button type="submit" id="contactus"><b>CONTACT</b></a></button>
          </div>

          <div class="subheader">
          </div>
        </div>


        <!-----------------------------/HEADER-------------->


    <form class="myForm" action="savefile1" method="post" enctype="multipart/form-data">

          <div class="cointainer">
                  <h1 id="productheader">ENTER DETAILS OF FILE</h1>
                
                  <h3>Description</h3>
                  <input  class="description" type="text" name="description" value="" required>


                  <h3>Select File:</h3>
                  <div class="imagesblock">	
                   Main Image:  <input class=" form-control" id="image" name="file" type="file"  required> <br><br>
                  </div>
                  <button class="button" type="submit" name="button">Save File</button>
              </div>

          </form>

  </body>
</html>
