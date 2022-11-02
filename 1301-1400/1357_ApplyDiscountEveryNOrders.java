class Cashier {
    int n;
    int discount;
    Map<Integer, Integer> m;
    int count = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.m = new HashMap<>();
        for (int i =0;i<products.length;i++) {
            m.put(products[i], prices[i]);
        }
    }
    
    
    public double getBill(int[] product, int[] amount) {
        count++;
        double total = 0;
        
        for(int i =0;i<product.length;i++) {
            total += m.get(product[i]) * amount[i];
        }
        
        if (count % n == 0) {
            total = total * (100-discount) / 100;
        }
        
        return total;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */