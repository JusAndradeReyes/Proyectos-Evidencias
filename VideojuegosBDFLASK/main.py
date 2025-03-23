# main.py
from app import create_app
from productos import prod
from proveedores import prove
from clientes import clie
from idiomas import idio
from carritos import carr
from usuarios import us
from flask_cors import CORS

app = create_app()
CORS(app)
app.register_blueprint(prod)
app.register_blueprint(prove)
app.register_blueprint(clie)
app.register_blueprint(idio)
app.register_blueprint(carr)
app.register_blueprint(us)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=55042, debug=True)