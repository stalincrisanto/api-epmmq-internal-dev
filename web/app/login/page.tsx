'use client';
import { Formik, Form, Field, ErrorMessage } from 'formik';

function login() {

  const handleSubmit = (values: { usuario: string; password: string }) => {
    console.log(values);
  }

  return (
    <div className='flex flex-col items-center justify-center min-h-screen py-2'>
       <div className='w-full max-w-md p-8 space-y-3 border border-gray-300 rounded-lg shadow-lg'>
    
        <Formik
          initialValues={{ usuario: '', password: '' }}
          onSubmit={(values) => {
            handleSubmit(values);
          }}
        >
          <Form className='flex flex-col gap-4 align-middle justify-center'>
                <h1>Ingreso al Sistema</h1>
                <Field
                    className='bg-gray-300 p-2 rounded ml-6 mr-6 h-10 outline-none'
                    type="username"
                    name="usuario"
                    placeholder="Usuario"
                />
                <ErrorMessage name="usuario" className="text-red-500 text-sm" />


                <Field
                    className='bg-gray-300 p-2 rounded ml-6 mr-6 h-10 outline-none'
                    type="password"
                    name="password"
                    placeholder="Password"
                />
                <ErrorMessage name="password" className="text-red-500 text-sm" />

                <div className='flex flex-row gap-4 align-middle justify-center'>
                  <button 
                  type="submit" 
                  className='bg-blue-500 text-white p-2 rounded hover:bg-blue-700 transition active:scale-90 h-10'
                  >
                    Conectar
                  </button>
                  <button 
                  type="button" 
                  className='bg-gray-500 text-white p-2 rounded hover:bg-gray-700 transition active:scale-90 h-10'
                  onClick={() => alert('Cancelar button clicked')}
                  >
                    Cancelar
                  </button>
                </div>
          </Form>
        </Formik>

       </div> 
    </div>
  )
}

export default login;