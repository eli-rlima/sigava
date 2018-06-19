package br.ufrpe.sigava.classes;

public class Login {

    private String usuario;
    private String senha;

    public Login (String usuario, String senha){
        setSenha(senha);
        setUsuario(usuario);
    }

    public boolean realizarLogin (Login senha){
        boolean retorno = false;
        if (senha.getSenha().equals(this.getSenha()) && senha.getUsuario().equals(this.getUsuario())){
            retorno = true;
        }
        return retorno;
    }

    public boolean realizarLogin(String user, String password){
        Login logar = new Login(user,password);
        return realizarLogin(logar);
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
