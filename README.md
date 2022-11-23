### [Cubic equation](https://en.wikipedia.org/wiki/Cubic_equation)

> An example of a Galois group $A_3$ with three elements is given by $p(x) = x^3 − 3x − 1$, whose discriminant is $81 = 9^2$.

Let $\omega$ be a primitive 18th root of unity,
so $\omega^9 = -1$
and
$\omega^3 - \omega^6 = 1$. Then


$$\displaylines{
a := \omega^7 - \omega^2 \approx -1.5320888862379558 \\
b := \omega^5 - \omega^4 \approx -0.3472963553338607 \\
c := \omega - \omega^8 \approx 1.8793852415718169 \\
}$$

are the solutions of $x^3 − 3x = 1$.

$$\displaylines{ (x - a) (x - b) (x - c) \\
= (x - \omega^7 + \omega^2) (x - \omega^5 + \omega^4) (x - \omega + \omega^8) \\
= x^3 + x^2 (- \omega^7 + \omega^2 - \omega^5 + \omega^4 - \omega + \omega^8) \\
\+ x (\omega^6 - \omega^{13} - \omega^5 + \omega^{12} + \omega^8 - \omega^{15} - \omega^3 + \omega^{10} + \omega^{12} - \omega^{11} - \omega^7 + \omega^6) \\
\- \omega^{13} + \omega^{20} + \omega^{12} - \omega^{19} + \omega^8 - \omega^{15} - \omega^7 + \omega^{14} \\
= x^3 + x^2 (\omega^2 ( \omega^6 - \omega^3 ) + \omega^2 + \omega ( \omega^3 - \omega^6 ) - \omega) \\
\+ x ( - \omega^{13} - \omega^5 + \omega^8 - \omega^{15} + \omega^{10} + \omega^{12} - \omega^{11} - \omega^7 - 2) \\
\+ \omega^4 + \omega^2 - \omega^3 - \omega + \omega^8 + \omega^6 - \omega^7 - \omega^5 \\
= x^3 + x (- \omega^{13} - \omega^5 + \omega^8 + \omega^{10} - \omega^{11} - \omega^7 - 3) - 1 \\
= x^3 - 3 x - 1 \\
}$$

There are some interesting relations among the roots:

$$\displaylines{
a^2 + b = 2 \\
b^2 + c = 2 \\
c^2 + a = 2 \\
}$$

### Viète's substitution

Substitute $ x = w + {1 \over w} $ and $ y = w^3 $, then

$$\displaylines{ 
y^2 - y + 1 = 0 \\
y = { 1 \over 2 } \pm { i \sqrt{3} \over 2 } \\
}$$

