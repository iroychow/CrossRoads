
package music.controller;

import java.io.IOException;


import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import music.business.Cart;
import music.business.Menu;
import music.business.MenuItem;
import music.data.ProductDB;
import music.data.UpcomingProductDB;




public class controller extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
	ServletContext context = getServletContext();
        String action = request.getParameter("action");
        String operationType = request.getParameter("operationType");
        HttpSession session = request.getSession(false);
        String url;
        
            if("viewmenubyuser".equalsIgnoreCase(action)){
                session.setAttribute("quantity", 0);
                displayAllMenu(request,response);
            }
             /*Add to cart*/
            else if("addtocart".equalsIgnoreCase(action)){
                 Cart cart = (Cart) session.getAttribute("cart");
                 if (cart == null)
                    cart = new Cart();
                 MenuItem menuItem=getMenuItem(request);
                 cart.addItem(menuItem);
                 
                 session.setAttribute("cart", cart);
                 session.setAttribute("quantity", cart.getTotalQuantity());
                 displayAllMenu(request,response);
                }
            
            /*Display cart*/
            else if("displaycart".equalsIgnoreCase(action)){
                Cart cart = (Cart) session.getAttribute("cart");
                if(cart!= null){
                displayAllCartItems(cart,request,response);
                }else{
                    displayAllMenu(request,response);
                }
            }
             /*Display upcoming items*/
            else if("upcomingitems".equalsIgnoreCase(action)){
             upcomingdisplayAllMenu(request,response);
                
            }
            
             /*Remove from  cart*/
            else if("removeFromCart".equalsIgnoreCase(action)){
                 Cart cart = (Cart) session.getAttribute("cart");
                 MenuItem menuItem=getMenuItem(request);
                 cart.removeItem(menuItem);
                 session.setAttribute("cart", cart);
                 displayAllCartItems(cart,request,response);
            }
            
            /*Remove item to cart*/
            else if("addItemtoCart".equalsIgnoreCase(action)){
                 Cart cart = (Cart) session.getAttribute("cart");
                 MenuItem menuItem=getMenuItem(request);
                 cart.addItem(menuItem);
                 session.setAttribute("cart", cart);
                 session.setAttribute("quantity", cart.getTotalQuantity());
                 displayAllCartItems(cart,request,response);
                }
            
            /*Clear cart*/
            else if("ClearAll".equalsIgnoreCase(action)){
              Cart cart=new Cart();
              session.setAttribute("cart", cart);
              session.setAttribute("quantity", 0);
              displayAllMenu(request,response);     
            }
            
       
        
            else if("displayProducts".equals(action))
            {
            List<Menu> product = ProductDB.selectProducts();            
            request.setAttribute("products", product);
            url="/products.jsp";
            getServletContext().getRequestDispatcher(url).forward(request,response);
            }
            
            
            
            else if(action.equalsIgnoreCase("addProduct")){
           //String operationType = request.getParameter("operationType");
            
            //1) for displaying existing product value
            if("displayProduct" .equalsIgnoreCase(operationType)){
            String code = request.getParameter("productCode");
            url="/product.jsp";
           
            Menu p= ProductDB.selectProduct(code);//method call
            request.setAttribute("product", p); 
            //url="/product.jsp";
            getServletContext().getRequestDispatcher(url).forward(request,response);
            }
            //2) for display empty page for new product
            else if("displayEmptyProduct".equalsIgnoreCase(operationType)){
                 url="/product.jsp";
                 getServletContext().getRequestDispatcher(url).forward(request,response);
            }
            //3) Add or update the product
            else if("Update Product".equalsIgnoreCase(operationType)){
            url="/products.jsp"; 
           Menu product = createProduct(request);
             if(ProductDB.codeExists(request.getParameter("Code")))
                 ProductDB.update(product);
            else {
                String validationMessage = checkValidationForAddProduct(product);
                if(validationMessage.equalsIgnoreCase("SUCCESS"))
                    ProductDB.insert(product);
                else{
                    url="/product.jsp"; 
                    request.setAttribute("message", validationMessage);
                }
                    
             }
             List<Menu> selectProducts = ProductDB.selectProducts();
                 request.setAttribute("products", selectProducts);
             //url="/products.jsp";
             getServletContext().getRequestDispatcher(url).forward(request,response);
            
            
        }    
            //4) view the product page
            else if("View Product".equalsIgnoreCase(operationType)){
                url="/products.jsp";
               List<Menu> products = ProductDB.selectProducts();
                 request.setAttribute("products", products);
            getServletContext().getRequestDispatcher(url).forward(request,response);
               }
        }
            
            
            
            else if("displayProduct".equals(action))
            {
            List<Menu> product = UpcomingProductDB.selectProducts();            
            request.setAttribute("products", product);
            url="/upcomingproducts.jsp";
            getServletContext().getRequestDispatcher(url).forward(request,response);
            }
             else if(action.equalsIgnoreCase("addProducts")){
           //String operationType = request.getParameter("operationType");
            
            //1) for displaying existing product value
            if("displayProduct".equalsIgnoreCase(operationType)){
            String code = request.getParameter("productCode");
            url="/upcomingproducts.jsp";
           
            Menu p= UpcomingProductDB.selectProduct(code);//method call
            request.setAttribute("product", p); 
            //url="/product.jsp";
            getServletContext().getRequestDispatcher(url).forward(request,response);
            }
            //2) for display empty page for new product
            else if("displayEmptyProducts".equalsIgnoreCase(operationType)){
                 url="/upcomingproduct.jsp";
                 getServletContext().getRequestDispatcher(url).forward(request,response);
            }
            //3) Add or update the product
            else if("Update Products".equalsIgnoreCase(operationType)){
            url="/upcomingproducts.jsp"; 
           Menu product = createProduct(request);
             if(UpcomingProductDB.codeExists(request.getParameter("Code")))
                 UpcomingProductDB.update(product);
            else {
                String validationMessage = checkValidationForAddProduct(product);
                if(validationMessage.equalsIgnoreCase("SUCCESS"))
                    UpcomingProductDB.insert(product);
                else{
                    url="/upcomingproduct.jsp"; 
                    request.setAttribute("message", validationMessage);
                }
                    
             }
             List<Menu> selectProducts = UpcomingProductDB.selectProducts();
                 request.setAttribute("products", selectProducts);
             //url="/products.jsp";
             getServletContext().getRequestDispatcher(url).forward(request,response);
            
            
        }    
            //4) view the product page
            else if("View Products".equalsIgnoreCase(operationType)){
                url="/products.jsp";
               List<Menu> products = UpcomingProductDB.selectProducts();
                 request.setAttribute("products", products);
            getServletContext().getRequestDispatcher(url).forward(request,response);
               }
        }
             
      else if(action.equalsIgnoreCase("deleteProduct")){
                url="/confirm_product_delete.jsp";
                Menu product = createProduct(request);
                //List<Product> selectProducts = ProductDB.selectProducts();
                request.setAttribute("product", product);
                context.getRequestDispatcher(url).forward(request, response);
           }
         else if(action.equalsIgnoreCase("deleteConfirmation")){
             
             Menu product = createProduct(request);
             ProductDB.delete(product);
               List<Menu> selectProducts = ProductDB.selectProducts();
                request.setAttribute("products", selectProducts);
                 url="/products.jsp";
                 context.getRequestDispatcher(url).forward(request, response);
         }
      
        
        }
      
@Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Menu createProduct(HttpServletRequest request){
                String code = request.getParameter("Code");
                String description = request.getParameter("Description");
                String price = request.getParameter("Price");
                Menu product = new Menu();
                product.setCode(code);
                product.setDescription(description);
                if(null!=price && !"".equals(price))
                        product.setPrice(Double.valueOf(price));
                return product;
    }
    
    private void displayAllCartItems(Cart cart,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
                List<MenuItem> items = cart.getItems();
                request.setAttribute("cartitems", items);
                request.setAttribute("totalCartQuantity", cart.totalCartItems());
                request.setAttribute("totalCartValue", cart.totalCartValuation());
                String url="/Checkout.jsp";
                getServletContext().getRequestDispatcher(url).forward(request,response);
    }
  
    private void displayAllMenu(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        List<Menu> menu = ProductDB.selectProducts();            
            request.setAttribute("menus", menu);
            String url="/menu.jsp";
            getServletContext().getRequestDispatcher(url).forward(request,response);
            
    }
    
    private void upcomingdisplayAllMenu(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        List<Menu> menu = UpcomingProductDB.selectProducts();            
            request.setAttribute("menus", menu);
            String url="/userupcomingproduct.jsp";
            getServletContext().getRequestDispatcher(url).forward(request,response);
            
    }
    
    private MenuItem getMenuItem(HttpServletRequest request){
                Menu menu=new Menu();
                 menu.setCode(request.getParameter("code"));
                 menu.setDescription(request.getParameter("description"));
                 menu.setPrice(Double.parseDouble(request.getParameter("price")));
                 
                  MenuItem menuItem = new MenuItem();
                 menuItem.setMenu(menu);
                 
                 return menuItem;
    }
    
    /*Validation for product*/
    private String checkValidationForAddProduct(Menu product){
        String message = "SUCCESS";
        if(null==product)
        {
            message="Please fill in all the required fields";
            
        }
        else if(product.getCode()==null ||"".equalsIgnoreCase(product.getCode().trim()))
        {
            message="Product code is mandatory";
        }
        else if(product.getPrice()==0.00)
        {
            message="Product price is mandatory";
        }
        else if(product.getDescription()==null ||"".equalsIgnoreCase(product.getDescription().trim()))
        {
            message="Product description is mandatory";
        }
        return message;
        
    } 
    
}
