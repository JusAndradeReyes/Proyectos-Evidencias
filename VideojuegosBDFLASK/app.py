# app.py
from flask import Flask
from config import MONGO_URI
from mongo import mongo

def create_app():
    app = Flask (__name__)
    app.config["MONGO_URI"] = MONGO_URI
    
    mongo.init_app(app)

    # Resto de la configuración de la aplicación

    return app