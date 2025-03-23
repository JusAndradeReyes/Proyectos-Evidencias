package org.ejemplo.uno;
/*
 * EJEMPLO: REALIZAR INYECCIÓN DE DEPENDENCIAS 
 * A TAVES DEL MÉTODO CONSTRUCTOR
 */
public class Triangle {

		private int height;
		private String type;
		
		//CONSTRUCTORES
		public Triangle() {
			super();
		}

		public Triangle(int height) {
			super();
			this.height = height;
		}

		public Triangle(int height, String type) {
			super();
			this.height = height;
			this.type = type;
		}
		
		//GETTERS AND SETTERS

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		
		//MP¿ÉTODO DE IMPRIMIR
		@Override
		public String toString() {
			return "Triangle [height=" + height + ", type=" + type + "]";
		}
}
