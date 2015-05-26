# sumário da variabilidade
print("Primeiro conjunto de dados");
x1=scan(file = "C:/Users/Avell/git/metodologia/TextTwistOptimization/R/DATASETS/memoria_BT.DAT", what = double(0), quiet = TRUE);

m = range(x1);
print( sprintf("range: %f a %f", m[1], m[2]) );

print(summary(x1));

m = var(x1);
print( sprintf("Variancia: %f", m));

m = sd(x1);
print( sprintf("Desvio padrao: %f", m));

m=sd(x1)/mean(x1);
print( sprintf("Coeficiente de variacao: %f", m));

m=quantile(x1, .1);
print( sprintf("Percentil 10%%: %f", m));

m=quantile(x1, .9);
print( sprintf("Percentil 90%%: %f", m));

m = IQR(x1);
print( sprintf("IQR: %f", m))
