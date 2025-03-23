from bson import ObjectId
from app import create_app
from mongo import mongo
from flask import Blueprint, jsonify, request
from bson.json_util import dumps
from datetime import datetime

#creación del módulo
idio=Blueprint("idio", __name__)

#----------------Método que retorna todos los idiomas-----------------------------
@idio.route('/idiomas/get_all', methods=['GET'])
def listar_pIdioma():
    data=mongo.db.idiomas.find({})
    r=dumps(data)
    return r

#----------------------------INSERTAR IDIOMAS----------------------------------
@idio.route('/idiomas/nuevoIdioma', methods=['POST'])
def add_idioma():
    #from flask import request
    id=request.json["_id"]
    nom=request.json["nomIdioma"]

    if request.method =='POST':
        product={"_id":id,
            "nomIdioma":nom
            }


    try:
        resultado = mongo.db.idiomas.insert_one(product)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "Documento insertado"})
        else:
            # Si no se pudo insertar el documento, devuelve un mensaje
            return jsonify({"mensaje": "Documento no insertado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#--------------------------------Eliminar un idioma por ID------------------------------------
@idio.route('/idiomas/eliminar/<string:id>', methods=['DELETE'])
def eliminar (id):
    try:
        resultado = mongo.db.idiomas.delete_one({'_id':id})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "documento eliminado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#------------------------------Actualizar un idioma por ID------------------------------------
@idio.route('/idiomas/actualizar/<string:id>', methods=['PUT'])
def actualizar_nombre(id):
    nuevo_nom=request.json["nomIdioma"]
    try:
        resultado = mongo.db.idiomas.update_one({'_id':id},{"$set": {"nomIdioma":nuevo_nom}})
        if resultado:
            actualizar_nombre (id, nuevo_nom)
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "Documento actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500
    
def actualizar_nombre(id, nuevo_nom):
    try:
        resultado = mongo.db.idiomas.update_one({'_id':id},{"$set": {"nomIdioma": nuevo_nom}})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "precio actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500