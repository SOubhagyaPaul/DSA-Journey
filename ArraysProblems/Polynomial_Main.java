class Polynomial {
    private int[] coef;   
    private int degree;   // degree of polynomial (-1 for the zero polynomial)
    
    
    public String toString() {
        if (degree == -1) return "0";
        else if (degree ==  0) return "" + coef[0];
        else if (degree ==  1) return coef[1] + "x + " + coef[0];
       
        String s = coef[degree] + "x^" + degree;
        
	for (int i = degree - 1; i >= 0; i--) {
           
            if (coef[i] == 0)      continue;
            else if (coef[i]  > 0) s = s + " + " + (coef[i]);
            else if (coef[i]  < 0) s = s + " - " + (-coef[i]);
           
            if (i == 1) s = s + "x";
            else if (i >  1) s = s + "x^" + i;
        }
        return s;
    }

    public Polynomial(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("exponent cannot be negative: " + b);
        }
        coef = new int[b+1];
        coef[b] = a;
        calcDegree();
    }

   
    private void calcDegree() {
        degree = -1;
        for (int i = coef.length - 1; i >= 0; i--) {
            if (coef[i] != 0) {
                degree = i;
                return;
            }
        }
    }
    
    /**
     * Returns the degree of this polynomial.
     * @return the degree of this polynomial, -1 for the zero polynomial.
     */
    
    public int degree() {
        return degree;
    }

    /*
     * Returns the sum of this polynomial and the specified polynomial.
     */
    public Polynomial plus(Polynomial that) {
        Polynomial poly = new Polynomial(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) 
        	poly.coef[i] += this.coef[i];
        for (int i = 0; i <= that.degree; i++) 
        	poly.coef[i] += that.coef[i];
        poly.calcDegree();
        return poly;
    }

    /**
     * Returns the result of Multiplication the specified polynomial from this polynomial.
     */
   
    public Polynomial product(Polynomial that) {
    	Polynomial poly = new Polynomial(0,this.degree+that.degree);
    	for (int i = 0; i < this.degree+1; i++)
		{
				for (int j = 0; j < that.degree+1; j++)	
				{
					poly.coef[i + j] += this.coef[i] * that.coef[j];
				}
				
		}
    	 poly.calcDegree();
         return poly;
    }

}



public class Polynomial_Main {

	public static void main(String[] args) {
	
          Polynomial p1   = new Polynomial(4, 3);
          Polynomial p2   = new Polynomial(3, 2);
          Polynomial p    = p1.plus(p2);  		  // 4x^3 + 3x^2

          Polynomial q1   = new Polynomial(3, 2);
          Polynomial q2   = new Polynomial(1, 2);
          Polynomial q    = q1.plus(q2);                   // 4x^2 
        
          Polynomial r1   = new Polynomial(3, 2);
          Polynomial r2   = new Polynomial(1, 2);
          Polynomial r    = r1.product(r2);  

          System.out.println(p);
          System.out.println(q);
          System.out.println(r);
	}

}
