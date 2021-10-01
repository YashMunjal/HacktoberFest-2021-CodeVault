## Subtract 1 without using ‘+’, ‘-‘, ‘*’, ‘/’, ‘++’, ‘–‘ …etc 

import java.io.*;
 class Sub
{
static int subtractone(int x)
{
    int m = 1;
 
    while (!((x & m) > 0))
    {
        x = x ^ m;
        m <<= 1;
    }
    x = x ^ m;
    return x;
}

public static void main (String[] args)
{
    System.out.println(subtractone(47));
}
}
