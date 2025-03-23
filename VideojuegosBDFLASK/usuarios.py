from bson import ObjectId
from app import create_app
from mongo import mongo
from flask import Blueprint, jsonify, request
from bson.json_util import dumps
from datetime import datetime


#creación del módulo
us=Blueprint("us", __name__)

#---------------------Método que retorna todos los usuarios-----------------------
# @us.route('/usuarios/get_all', methods=['GET'])
# def listar_usuarios():
#     data=mongo.db.usuarios.find({})
#     r=dumps(data)
#     return r
@us.route('/usuarios/get_all', methods=['GET'])
def obtenerUsuarios():
    data=mongo.db.usuarios.find({}) # ,{"_id":0}
    r = []
    for usuario in data:
        usuario['_id'] = str(usuario['_id']) # Convertir ObjectId a cadena
        r.append(usuario)
    return r

#-----------------------Método que retorna un usuarios por id------------------------------
@us.route('/usuarios/porID/<string:id>', methods=['GET'])
def obtener_PorID(id):
    query={'_id':id}
    project = {"password":1,"email": 1,"rol":1}
    try:
        resultado=mongo.db.usuarios.find_one(query, project)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify(resultado)
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus
        return jsonify({"error": str(e)}), 500

#----------------------------INSERTAR USUARIOS----------------------------------
@us.route('/usuarios/nuevoUsuario', methods=['POST'])
def add_usuario():
    #from flask import request
    id=request.json["_id"]  
    ema=request.json["email"]
    pssw=request.json["password"]
    rol=request.json["rol"]
    foto=request.json["foto"]

    if request.method =='POST':
        product={"_id":id,
            "email":ema,
            "password":pssw,
            "rol":rol,
            "foto":foto
            }

    try:
        resultado = mongo.db.usuarios.insert_one(product)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "Documento insertado"})
        else:
            # Si no se pudo insertar el documento, devuelve un mensaje
            return jsonify({"mensaje": "Documento no insertado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500
    
# #---------------------------------Inner Join---------------------------------------------------------
# @carr.route('/carritos/carr_clie', methods=['GET'])
# def obtener_carr_clie():
#     query = [
#         {
#             '$lookup': {
#                 'from': "clientes",
#                 'localField': "clienteId",  
#                 'foreignField': "_id",
#                 'as': "cliente"
#             }
#         },
#         {
#             '$unwind': "$cliente" # Deshacer el array creado por $lookup
#         },
#         {
#             '$project': {
#                 "listaProd":1,
#                 "fecha_creacion": 1,
#                 "cliente.nomcliente.nombre": 1,
#                 "cliente.nomcliente.appellido1": 1,
#                 "cliente.nomcliente.apellido2": 1,
#                 "cliente.direccion.pais": 1,
#                 "cliente.direccion.provincia": 1
#             }
#         }   
#     ]
#     try:
#         resultado = mongo.db.carritos.aggregate(query)
#         if resultado:
#             # Si la consulta es exitosa, devuelve los datos en formato JSON
#             return list(resultado)
#         else:
#             # Si no se encuentra el documento, devuelve un mensaje adecuado
#             return jsonify({"mensaje": "Documento no encontrado"}), 404
#     except Exception as e:
#         # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
#         return jsonify({"error": str(e)}), 500

#--------------------------------Eliminar un usuario por ID------------------------------------
@us.route('/usuarios/eliminar/<string:id>', methods=['DELETE'])
def eliminar (id):
    try:
        resultado = mongo.db.usuarios.delete_one({'_id':id})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "documento eliminado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#-----------------------------Actualizar un usuario por ID----------------------------------------
@us.route('/usuarios/actualizar/<string:id>', methods=['PUT'])
def actualizar_email(id):
    
    nuevo_rol=request.json["rol"] 
    nuevo_password =request.json["password"] 
    nuevo_email=request.json["email"]
    try:
        resultado = mongo.db.usuarios.update_one({'_id':id},{"$set": {"email":nuevo_email, "rol":nuevo_rol, "password":nuevo_password}})
        if resultado:
            actualizar_email(id, nuevo_email)
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "Documento actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"}), 404
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500
    
def actualizar_email(id, nuevo_email):
    try:
        resultado = mongo.db.usuarios.update_one({'_id':id},{"$set": {"email":nuevo_email}})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "precio actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500
    
def actualizar_email(id, nuevo_email):
    try:
        resultado = mongo.db.usuarios.update_one({'_id':id},{"$set": {"email":nuevo_email}})
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"mensaje": "precio actualizado"})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"mensaje": "Documento no encontrado"})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus necesidades
        return jsonify({"error": str(e)}), 500

#----------------------------------Login Usuarios---------------------------------------- 
@us.route('/usuarios/login/<string:correo>/<string:clave>', methods=['GET'])
def login(correo,clave):
    query={'email':correo,'password': clave}
    try:
        resultado=mongo.db.usuarios.find_one(query)
        if resultado:
            # Si la consulta es exitosa, devuelve los datos en formato JSON
            return jsonify({"login": True})
        else:
            # Si no se encuentra el documento, devuelve un mensaje adecuado
            return jsonify({"login": False})
    except Exception as e:
        # Manejo de la excepción, puedes personalizar el mensaje de error según tus
        return jsonify({"error": str(e)}), 500