from flask import render_template, flash, redirect
from app import app
from .forms import *
import os,shutil
from flask import  request, redirect, url_for
from werkzeug.utils import secure_filename
from flask import send_from_directory
from file_extraction import extract_files

UPLOAD_FOLDER = '/home/shruthi/Flask/Form2/app/uploads'
ALLOWED_EXTENSIONS = set(['zip', 'tar','gz','tar.gz', 'pdf','jpg', 'jpeg', 'gif'])

app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
zipobj={}

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
    li=["Images","Videos",'Audios','Documents']
    if request.method == 'POST':
       	    x=request.form.getlist('selecttype')
            for i in li:
                if i not in x:
                    n=request.form.getlist('filepath')[0]
                    print "here :::"+n+"/"+(i.lower());
                    if os.path.exists(n+"/"+i.lower()):
                        shutil.rmtree(n+"/"+i.lower())
            return  redirect(url_for('questions'))
    global zipobj
    print zipobj
    for i in li:
        if(i not in zipobj.keys()):
            flash('You do not have any '+i)
    return  render_template('select_type.html',arr=zipobj)


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
            global zipobj
            zipobj=extract_files(app.config['UPLOAD_FOLDER'],filename);
            print(zipobj)
            return redirect(url_for('select_type'))

    form=UploadFile()
    return render_template('import.html',form=form)
