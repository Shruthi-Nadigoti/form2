from flask import render_template, flash, redirect
from app import app
from .forms import *
import os
from flask import  request, redirect, url_for
from werkzeug.utils import secure_filename
from flask import send_from_directory


UPLOAD_FOLDER = '/home/shruthi/Flask/Form2/app/uploads'
ALLOWED_EXTENSIONS = set(['zip', 'tar','gz','tar.gz', 'pdf','jpg', 'jpeg', 'gif'])

app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

@app.route('/questions', methods=['GET', 'POST'])
def questions():
    if request.method == 'POST':
        print(request.form.getlist('hello'))
        print(request.form.getlist('add'))
        return "success"
    arr=["Tag the Image","Describe the image","Count the number of human beings"] 
    return  render_template('tags.html',arr=arr)

@app.route('/select_type',methods=['GET', 'POST'])
def select_type():
	if request.method == 'POST':
       		 print(request.form.getlist('selecttype'))
        	 return  redirect(url_for('questions'))
 	arr=["Images","videos","Documents","Audio"]      
    	return  render_template('select_type.html',arr=arr)
    	
@app.route('/uploads/<filename>')
def uploaded_file(filename):
    return send_from_directory(app.config['UPLOAD_FOLDER'],
                               filename)

def allowed_file(filename):
    return '.' in filename and \
           filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS
@app.route('/files')
def files():
   form=UploadFile()
   return render_template('import.html',
                           title='Import File',
                           form=form)
@app.route('/import', methods=['GET', 'POST'])
def upload_file():
    if request.method == 'POST':
        # check if the post request has the file part
        if 'file' not in request.files:
            flash('No file part')
            return redirect(request.url)
        file = request.files['file']
        # if user does not select file, browser also
        # submit a empty part without filename
        if file.filename == '':
            flash('No selected file')
            return redirect(request.url)
        if file and allowed_file(file.filename):
            filename = secure_filename(file.filename)
            file.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))
            return redirect(url_for('select_type'))
    form=UploadFile() 
    return render_template('import.html',form=form)
 
