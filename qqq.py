a = int(input())
b = int(input())
c = int(input())
if a == 0:
    print("Квадратного уравнения нет")
else:
    d = b**2 - (4 * a * c)
    if d < 0:
        print("Корней нет")
    else:
        if d > 0:
            x1 = (-b + d**0.5) / (2 * a)
            x2 = (-b - d**0.5) / (2 * a)
            print(x1, x2)
        else:
            x = -b/(2 * a)
            print(x)
