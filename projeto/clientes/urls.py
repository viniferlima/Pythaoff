from django.urls import path
from .views import home, pesq, test_testeagain

urlpatterns = [
    path('', home),
    path('scrap/', test_testeagain),
]
