from flask import render_template, flash, redirect
from app import app
from .forms import *
import os,shutil #used for creation of folders 
from flask import  request, redirect, url_for
from werkzeug.utils import secure_filename
from flask import send_from_directory
from file_extraction import extract_files #this is the custom method for extraction of files

UPLOAD_FOLDER = '/home/shruthi/Flask/Form2/app/uploads' #this is the where we want to store the files
ALLOWED_EXTENSIONS = set(['zip', 'tar','gz','tar.gz', 'pdf','jpg', 'jpeg', 'gif'])

app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER 
zipobj={}

@app.route('/questions', methods=['GET', 'POST'])
def questions():
    if request.method == 'POST':
        print(request.form.getlist('hello')) #this is the list of predefined tags which were selected by user
        print(request.form.getlist('add')) #this is the list of custom tags
        return "success"
    arr=["Tag the Image","Describe the image","Count the number of human beings"]#these are the predefined tags
    return  render_template('tags.html',arr=arr) #we are going to tags.html

@app.route('/select_type',methods=['GET', 'POST'])# this url is for the selecting types of folders which user want
def select_type():
    li=["Images","Videos",'Audios','Documents'] #classification files 
    if request.method == 'POST':
       	    x=request.form.getlist('selecttype') #selected classification list
            for i in li:
                if i not in x:
                    n=request.form.getlist('filepath')[0]#this is parent path of the folder which were unchecked by user
                    if os.path.exists(n+"/"+i.lower()): 
                        shutil.rmtree(n+"/"+i.lower()) #deletion of folder
            return  redirect(url_for('questions'))
    global zipobj
    for i in li:
        if(i not in zipobj.keys()): 
            flash('You do not have any '+i) #giving information about the folders which user don't have
    return  render_template('select_type.html',arr=zipobj) #sending the classified information to the select_type.html


@app.route('/uploads/<filename>') # this method is for getting the directory of the file which was uploaded
def uploaded_file(filename):
    return send_from_directory(app.config['UPLOAD_FOLDER'],
                               filename)

def allowed_file(filename):   #return the true if it is allowed extension otherwise returns the false
    return '.' in filename and \
           filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS
           
           
           
@app.route('/import', methods=['GET', 'POST']) #this url for the uploading the file
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
        if file and allowed_file(file.filename): #checking whether filename is in allowed extentions
            filename = secure_filename(file.filename) #we are giving secure name to the file
            file.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))#saving the file to the corresponding path
            global zipobj
            zipobj=extract_files(app.config['UPLOAD_FOLDER'],filename); #we are calling extract_files method to classify the different files in the uploaded file
            print(zipobj)
            return redirect(url_for('select_type')) #after uploading we are going to the select_type url

    form=UploadFile()
    return render_template('import.html',form=form)
