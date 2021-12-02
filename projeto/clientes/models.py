from django.db import models

class pedido(models.Model):
    bebida = models.CharField(max_length=20)
    marca = models.CharField(max_length=20)
    quant = models.CharField(max_length=10)

    def __str__(self):
        return self.bebida

# Create your models here.
