package mathExt;

import java.util.Random;

public class Vectorn {
    public double[] vars;

    // making class        <<<----------------------->>>
    public Vectorn(double[] vars) // with two variables
    {
        this.vars = vars;
    }
    public Vectorn(Vectorn vec)
    {
        clone(vec.vars);
    }
    public Vectorn(double value, int n)
    {
        clone(value, n);
    }
    public Vectorn(int n)
    {
        vars = new double[n];
    }
    public void random(Random rnd, int[] range)
    {
        for (int i = 0; i < vars.length; i++) {
            set(rnd.nextInt((range[1]-range[0])+1)+range[0], i);
        }
    }
    private void clone(double[] var)
    {
        vars = new double[var.length];
        for (int i = 0; i < var.length; i++) {
            vars[i] = var[i];
        }
    }
    private void clone(double value, int n)
    {
        vars = new double[n];
        for (int i = 0; i < n; i++) {
            vars[i] = value;
        }
    }
    public void set(double[] var)
    {
        if(var.length == vars.length)
            for (int i = 0; i < var.length; i++)
                vars[i] = var[i];
    }
    public void set(Vectorn vec)
    {
        if(vec.vars.length == vars.length)
            for (int i = 0; i < vec.vars.length; i++)
                vars[i] = vec.vars[i];
    }
    public void set(double value) {
        for (int i = 0; i < vars.length; i++)
            vars[i] = value;
    }
    public void set(double value, int i) {
        if(i < vars.length)
        vars[i] = value;
    }
    public void zero() // makes vector one
    {set(0);}
    public void one() // makes vector one
    {set(1);}
    // simple functions <<<----------------------->>>
    public void add(Vectorn vec) // adding two vectors
    {
        if(vec.vars.length == vars.length)
            for (int i = 0; i < vec.vars.length; i++)
                vars[i] += vec.vars[i];
    }
    public void add(double scalar) // adding scalar to vector
    {
        for (int i = 0; i < vars.length; i++)
            vars[i] += scalar;
    }
    public void sub(Vectorn vec) // subtract two vectors
    {
        if(vec.vars.length == vars.length)
            for (int i = 0; i < vec.vars.length; i++)
                vars[i] -= vec.vars[i];
    }
    public void sub(double scalar) // subtract scalar from vector
    {
        for (int i = 0; i < vars.length; i++)
            vars[i] -= scalar;
    }
    public void multNot(mathExt.Vector vec) // multiplying two vectors -> maybe not correct
    {
        //
    }
    public void mult(double scalar) // multiplying scalar to vector
    {
        for (int i = 0; i < vars.length; i++)
            vars[i] *= scalar;
    }
    public void multOnAdd(Vectorn vec, double scal) // multiplies then adds value then divides by initial multplication
    {
        vec.mult(scal);
        this.add(vec);
        vec.div(scal);
    }
    public void div(double scalar) // dividing scalar to vector
    {
        if(scalar != 0){
            for (int i = 0; i < vars.length; i++)
                vars[i] /= scalar;
        }
    }
    // overide functions <<<----------------------->>>
    public boolean equals(Vectorn o) // equals function
    {
        for (int i = 0; i < vars.length; i++)
            if(vars[i] != o.vars[i]) return false;
        return true;
    }
    public String toString() // returning class values
    {
        String str = "";
        for (int i = 0; i < vars.length; i++)
            str += "|"+i+":"+vars[i];
        return str;
    }

    // complex functions <<<----------------------->>>
        /*public double dir() // returns vector scalar direction
        {
        }*/
    public double mag() // returns magnitude of vector
    {
        return Math.sqrt(magSqr());
    }
    public double magSqr() // returns magnitude of vector squared
    {
        double magnitude = 0;
        for (int i = 0; i < vars.length; i++)
            magnitude += vars[i]*vars[i];
        return magnitude;
    }
    public Vectorn normal() // returns normal of vector
    {
        double mag = mag();
        if(mag > 0) {
            Vectorn vec = new Vectorn(this);
            vec.div(mag);
            return vec;
        }
        else
            return new Vectorn(0, vars.length);
    }
    public void normalize() // normalizes all vector values
    {
        Vectorn n = normal();
        set(n);
    }
    public void setMag(double mag)
    {
        normalize();
        mult(mag);
    }
    public double distance(Vectorn other, Vectorn other2) // makes a distance vector
    {
        this.set(other);
        this.sub(other2);
        return mag();
    }
}
