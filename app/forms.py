from flask_wtf import Form
from wtforms import StringField, BooleanField
from wtforms.validators import DataRequired
from flask_wtf.file import FileField, FileRequired

class LoginForm(Form):
    openid = StringField('openid', validators=[DataRequired()])
    remember_me = BooleanField('remember_me', default=False)
   
class UploadFile(Form):
 	files=FileField('file',validators=[FileRequired()])


	
