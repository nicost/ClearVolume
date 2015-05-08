#version 150
 
 /**
 * Fragment shader for rendering layer textures.
 *
 * @author Loic Royer 2014
 *
 */
 
// IMPORTANT NOTE: do not remove the 'insertpoint' comments, this is used to automatically generate variants of this shader  
 
uniform float lod; 
 
uniform sampler2D texUnit0; 
//insertpoint1
 

in vec2 ftexcoord;

out vec4 outColor;
 

 
void main()
{
    vec4 tempOutColor = textureLod(texUnit0, ftexcoord, lod);
    //insertpoint2
    
    outColor = tempOutColor;
}
